(defproject json-reader "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure    "1.6.0"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  :resource-paths ["resources/jars/jackson-annotations-2.6.1.jar" 
                   "resources/jars/jackson-core-2.6.1.jar" 
                   "resources/jars/jackson-databind-2.6.1.jar"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
