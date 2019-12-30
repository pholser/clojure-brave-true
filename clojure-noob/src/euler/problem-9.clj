(ns clojure-noob.euler
  (:require
    [clojure.math.combinatorics :as combo]))

(def pythagorean-pairs
  (combo/cartesian-product (range 1 1000) (range 1 1000)))
(def pythagorean-triples
  (filter
    (fn [[a b c]] (== c (int c)))
    (map
      (fn [[a b]] [a b (Math/sqrt (+ (* a a) (* b b)))])
      pythagorean-pairs)))

(def problem-9
  (let [[a b c]
         (first
           (filter (fn [[a b c]] (== 1000 (+ a b c))) pythagorean-triples))]
    (* a b (int c))))

