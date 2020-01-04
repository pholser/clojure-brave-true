(ns fwpd.core
  (:require
    [clojure.string :as st]))

(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])

(defn str->int [str] (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert lines of CSV into rows of columns"
  [string]
  (map #(st/split % #",") (st/split string #"\n"))) 

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map
    (fn [unmapped-row]
      (reduce
        (fn [row-map [vamp-key value]]
          (assoc row-map vamp-key (convert vamp-key value)))
        {}
        (map vector vamp-keys unmapped-row)))
    rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

