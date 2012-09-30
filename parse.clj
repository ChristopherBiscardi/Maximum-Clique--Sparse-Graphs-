(ns parse 
  "parsing of .clq"
  (:require graphs))

(defn parse [nn graph]
  "Parse Clojure Map"
  (loop [n nn]
    (when (> n 0)
      (print n)
      (print " [")
      (loop [g graph]
        (if (not (empty? g))
          (let [g1 (first g)]
            (if (some #(= n %) (val g1))
              (let [k (key g1)]
                (print " ")
                (print (key g1))))
            (recur (rest g)))))
      (println "]")
      (recur (- n 1)))))

(parse 64 graphs/hamming6-4) 

(println (merge-with concat graphs/hamming6-4-extra graphs/hamming6-4))
