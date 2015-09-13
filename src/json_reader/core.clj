(ns json-reader.core
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

(defn start-parser
  "Kick off a go-block to parse a character input stream or reader of JSON source."
  [src-stream]
  (let [jp         (open-parser src-stream)
        token-chan (async/chan)]
    (async/go-loop 
      [token (.nextToken jp)]
      (if token 
        (do
          (when verbose
            (println (str "token: " (.toString token))))
          (async/put! token-chan token)
          (recur (.nextToken jp)))
        (do
         (async/close! token-chan)
         (close-parser jp))))

    token-chan))
