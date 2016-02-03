(ns game-of-life-clojure.logic
  (:use game-of-life-clojure.load)
  (:use game-of-life-clojure.display))

(defn next-generation [data]
  (load-random 10))

(defn tick [data]
  (println "====== tick")
  (Thread/sleep 1000)
  (display! data)
  (next-generation data)
  )

(defn run [seed-data]
  (dorun (iterate tick seed-data)))
