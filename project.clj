(defproject sparky "0.2.1"
  :description "Clojure wrapper around Jackson streaming JSON parser."
  :url "https://github.com/rstinejr/clojure-json"
  :license {:name "The MIT License (MIT)"
            :url "https://github.com/rstinejr/clojure-json/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure    "1.6.0"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [com.fasterxml.jackson.core/jackson-core "2.6.1"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev { :plugins [[lein-marginalia "0.8.0"]]}})
