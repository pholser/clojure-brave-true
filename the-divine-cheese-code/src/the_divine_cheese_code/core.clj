(ns the-divine-cheese-code.core)

(require 'the-divine-cheese-code.visualization.svg)
(alias 'svg 'the-divine-cheese-code.visualization.svg)

(def heists
  [
   {:location "Cologne, Germany"
    :cheese-name "Archbishop Hildebold's Cheese Pretzel"
    :lat 50.95
    :lng 6.97}
   {:location "Zurich, Switzerland"
    :cheese-name "The Standard Emmental"
    :lat 47.37
    :lng 8.55}
   {:location "Marseilles, France"
    :cheese-name "Le Fromage de Cosquer"
    :lat 47.37
    :lng 8.55}
   {:location "Zurich, Switzerland"
    :cheese-name "The Lesser Emmental"
    :lat 47.37
    :lng 8.55}
   {:location "Vatican City"
    :cheese-name "The Cheese of Turin"
    :lat 41.90
    :lng 12.45}])

(defn -main
  [& args]
  (println (svg/points heists)))
