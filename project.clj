(defproject game-of-life-clojure "0.1.0-SNAPSHOT"
  :description "Game of Life sample implementation in Clojure"
  :url "https://github.com/ivos/game-of-life-clojure"
  :license {:name "Apache 2"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [seesaw "1.4.5"]]

  :main ^:skip-aot game-of-life-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
