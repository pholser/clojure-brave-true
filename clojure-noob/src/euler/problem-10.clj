(ns clojure-noob.euler)

(def odds (iterate (fn [n] (.add n (biginteger 2))) (biginteger 3)))

(defn prime? [n] (.isProbablePrime n 1000))
(defn problem-10 [top]
  (reduce +
    (filter prime?
      (take-while (partial > top) (cons (biginteger 2) odds)))))

