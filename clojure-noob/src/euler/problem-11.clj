(ns clojure-noob.euler
  (:require
    [clojure.string :as st]))

(def horizontal-fours-coordinates
  (partition 4
    (for [r (range 0 20) c (range 0 17) i (range 0 4)] [r (+ c i)])))
(def vertical-fours-coordinates
  (partition 4
    (for [r (range 0 17) c (range 0 20) i (range 0 4)] [(+ r i) c])))
(def backslash-fours-coordinates
  (partition 4
    (for [r (range 0 17) c (range 0 17) i (range 0 4)] [(+ r i) (+ c i)])))
(def slash-fours-coordinates
  (partition 4
    (for [r (range 3 20) c (range 0 17) i (range 0 4)] [(- r i) (+ c i)])))
(defn value-at [grid [r c]]
  (nth (nth grid r) c))
(defn product-of [grid [c1 c2 c3 c4]]
  (reduce * (map (partial value-at grid) [c1 c2 c3 c4])))


(def p11-rows
  (map #(st/split % #" ") (st/split-lines (slurp "src/euler/p11.txt"))))
(def p11-grid
  (into []
    (map
      (fn [row] (into [] (map #(Integer/parseInt %) row))) p11-rows)))

(defn problem-11 []
  (apply max
    (map
      (partial product-of p11-grid)
      (concat
        horizontal-fours-coordinates 
        vertical-fours-coordinates
        backslash-fours-coordinates
        slash-fours-coordinates))))

