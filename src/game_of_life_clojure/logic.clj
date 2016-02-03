(ns game-of-life-clojure.logic
  (:use game-of-life-clojure.display))

(def tick-delay-ms 100)

(defn wrap [value min-value max-value]
  (let [max-value-inclusive (- max-value 1)]
    (if (< value min-value) max-value-inclusive (if (> value max-value-inclusive) min-value value))
    ))

(defn cell-value-wrapping [data x y]
  (let [x-wrapped (wrap x 0 (count data))
        y-wrapped (wrap y 0 (count (nth data x-wrapped)))]
    (nth (nth data x-wrapped) y-wrapped)
    ))

(defn neighbor [data x y]
  (if (cell-value-wrapping data x y) 1 0))

(defn count-neighbors [data x y]
  (+
    (neighbor data (- x 1) (- y 1))
    (neighbor data (- x 1) y)
    (neighbor data (- x 1) (+ y 1))
    (neighbor data x (- y 1))
    (neighbor data x (+ y 1))
    (neighbor data (+ x 1) (- y 1))
    (neighbor data (+ x 1) y)
    (neighbor data (+ x 1) (+ y 1))))

(defn next-cell [data x y]
  (let [current (nth (nth data x) y)
        neigbors-count (count-neighbors data x y)]
    (if (or
          (and current (and (>= neigbors-count 2) (<= neigbors-count 3)))
          (and (not current) (== neigbors-count 3))
          )
      true false)
    ))

(defn next-generation [data]
  (for [x (range (count data))]
    (for [y (range (count (nth data x)))]
      (next-cell data x y))))

(defn tick [data]
  (println "====== tick")
  (Thread/sleep tick-delay-ms)
  (display! data)
  (next-generation data)
  )

(defn run [seed-data]
  (dorun (iterate tick seed-data)))
