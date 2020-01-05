(ns clojure-noob.euler
  (:require
    [clojure.string :as st]))

(def p13-first-elevens
  (map
    #(Long/parseLong %)
    (map #(subs % 0 11) (st/split-lines (slurp "src/euler/p13.txt")))))

(def problem-13
  (subs (str (reduce + p13-first-elevens)) 0 10))
