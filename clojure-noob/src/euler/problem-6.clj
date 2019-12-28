(ns clojure-noob.euler)

(defn sum-of-squares [n]
  (reduce + (map #(* % %) (take n (iterate inc 1)))))
(defn square-of-sum [n]
  (let [sum (reduce + (take n (iterate inc 1)))] (* sum sum)))

(defn problem-6 [n]
  (Math/abs (- (sum-of-squares n) (square-of-sum n))))

