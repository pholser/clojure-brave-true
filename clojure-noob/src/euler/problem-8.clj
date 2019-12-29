(ns clojure-noob.euler
  (:require
    [clojure.string :as st]))

(def p8-digits
  (map #(- (int %) 48) (st/replace (slurp "src/euler/p8.txt") #"\n" "")))
(def windows-of-thirteen (partition 13 1 p8-digits))

(def problem-8
  (apply max (map #(reduce * %) windows-of-thirteen)))
