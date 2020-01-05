(ns clojure-noob.euler)

(defn collatz-next [n] (if (odd? n) (+ 1 (* 3 n)) (quot n 2)))
(defn collatz [n]
  (take-while #(not= 1 %) (iterate collatz-next n)))
(def collatz-memo (memoize collatz))

(defn problem-14 [top]
  (apply max-key #(count (collatz-memo %)) (range 1 top)))
