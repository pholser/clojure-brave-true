(ns clojure-noob.euler)

(defn multiple-of? [divisor n]
  (= 0 (mod n divisor)))

(def multiple-of-3? (partial multiple-of? 3))
(def multiple-of-5? (partial multiple-of? 5))

(defn problem-1 []
  (reduce +
    (filter
      (fn [n] (or (multiple-of-3? n) (multiple-of-5? n)))
      (range 1000))))
