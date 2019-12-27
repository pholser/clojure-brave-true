(ns clojure-noob.euler
  (:require
    [clojure.math.combinatorics :as combo]
    [clojure.string :as st]))

(defn palindromic-number? [n]
  (let [s (str n)] (= s (st/reverse s))))

(def problem-4
  (apply max
    (filter
      palindromic-number?
      (map
        #(reduce * %)
        (combo/cartesian-product (range 100 1000) (range 100 1000))))))

