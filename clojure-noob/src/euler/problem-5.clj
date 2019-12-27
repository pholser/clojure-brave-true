(ns clojure-noob.euler)

(defn evenly-divisible-by? [d n] (= 0 (rem n d)))
(defn evenly-divisible-by-1-through? [d]
  (apply
    every-pred
    (map (fn [m] (partial evenly-divisible-by? m)) (range d 1 -1))))

(defn problem-5 [d]
  (first
    (filter
      (evenly-divisible-by-1-through? d)
      (iterate (partial + d) d))))
