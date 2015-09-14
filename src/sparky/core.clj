(ns sparky.core
  (:require [clojure.core.async :as async]
            [clojure.java.io]))

(def verbose true)

(defn file-to-stream
  [json-src]
  (let [file (clojure.java.io/file json-src)]
    (when (not (.isFile file))
      (throw (ex-info (str "JSON source file '" json-src "' not found.") {:causes #{:file-not-found}})))
    (clojure.java.io/input-stream file)))
  
(defn open-parser
  "given a JSON character stream, return a parser."
  [json-stream]
    (let [factory (com.fasterxml.jackson.core.JsonFactory.)]
      (.createParser factory json-stream)))

(defn close-parser
  [json-parser]
  (.close json-parser))

(defn get-value
  [jp token-k]
  (case token-k
    :VALUE_FALSE        false
    :VALUE_STRING       (.getText jp)
    :VALUE_TRUE         true
    :VALUE_NUMBER_INT   (.getLongValue jp)
    :VALUE_NUMBER_FLOAT (.getDoubleValue jp)
    nil))

(defn get-item-attribs
  [jp token]
  (let [token-k (keyword (.toString token))]
    {:token token-k :name (.getCurrentName jp) :value (get-value jp token-k)}))

(defn put-msg
  [ch msg]
  (when verbose
    (println (str "item: " msg)))
  (async/put! ch msg))

(defn start-parser
  "Kick off a go-block to parse a character input stream or reader of JSON source."
  [src-stream]
  (let [jp         (open-parser src-stream)
        token-chan (async/chan)]
    (async/go-loop [ ]
      (if-let [token 
                 (try
                   (.nextToken jp)
                   (catch Throwable t 
                     (do
                       (put-msg token-chan {:token :ERROR :msg (.getMessage t)})
                       nil)))]
        (let [item-attribs (get-item-attribs jp token)]
          (put-msg token-chan item-attribs)
          (recur))
        (do
          (async/close! token-chan)
          (close-parser jp))))

    token-chan))
