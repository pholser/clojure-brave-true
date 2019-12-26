(ns clojure-noob.euler)

(defn two-factors
  ([n] (two-factors n '()))
  ([number factors]
    (loop [n number fs factors]
      (let [r (rem n 2) q (quot n 2)]
        (if (not= r 0)
          [fs n] 
          (recur q (cons 2 fs)))))))

(defn odd-factors
  ([n] (odd-factors n 3 '()))
  ([number divisor factors]
    (loop [n number d divisor fs factors]
      (if (> (* d d) n)
        (if (not= n 1) 
          (cons n fs)
          fs)
        (let [r (rem n d) q (quot n d)]
          (if (not= r 0)
            (recur n (+ d 2) fs) 
            (recur q d (cons d fs))))))))

(defn prime-factors [n]
  (let [[factors leftover] (two-factors n)]
    (concat factors (odd-factors leftover))))

(def problem-3 (apply max (prime-factors 600851475143)))

