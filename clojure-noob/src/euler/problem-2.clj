(ns clojure-noob.euler)

; https://en.wikibooks.org/wiki/Clojure_Programming/Examples/Lazy_Fibonacci
(def fib-seq
  (lazy-cat [1 2] (map + (rest fib-seq) fib-seq)))

(def problem-2
  (reduce + (filter even? (take-while #(< % 4000000) fib-seq))))
