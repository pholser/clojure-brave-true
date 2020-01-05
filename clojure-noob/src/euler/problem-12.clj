(ns clojure-noob.euler)

; from "Clojure for the Brave and True
(defn triangle-numbers
  ([] (triangle-numbers 0 1))
  ([sum n]
     (let [new-sum (+ sum n)]
       (cons new-sum (lazy-seq (triangle-numbers new-sum (inc n)))))))

(defn factors-of [n]
  (filter #(= 0 (rem n %)) (range 1 (inc n))))

(defn problem-12 [top]
  (first
    (filter
      #(and (> % 2162160) (> (count (factors-of %)) top))
      (triangle-numbers))))
