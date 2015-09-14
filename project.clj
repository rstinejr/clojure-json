(defproject sparky "0.1.1"
  :description "Clojure wrapper around Jackson streaming JSON parser."
  :url "https://github.com/rstinejr/clojure-json"
  :license {:name "The MIT License (MIT)"
            :url "https://github.com/rstinejr/clojure-json/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure    "1.6.0"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  :resource-paths ["resources/jars/jackson-annotations-2.6.1.jar" 
                   "resources/jars/jackson-core-2.6.1.jar" 
                   "resources/jars/jackson-databind-2.6.1.jar"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev { :plugins [[lein-marginalia "0.8.0"]]}})
