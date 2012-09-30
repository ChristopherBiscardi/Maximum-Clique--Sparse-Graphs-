(ns exact
  "Implementation of this formula: http://arxiv.org/abs/1209.5818"
  (:require graphs))

(defn d [vi]
  (count (val vi)))

(defn maxclique [G lb]
  "Implementation of the MAXCLIQUE exact formula"
  (let [nn 0]
    (loop [g G
           ourMax lb
           n nn]
      (println n)
      (when (> (d (first g)) ourMax)
        (let [vi (key (first g))]
          (loop [U '()
                 g2 g
                 vj (first (val (first g)))]
            (when (and
                    (> vj vi)
                    (>= (d (find G vj)) ourMax))
              (recur (conj U vj)
                     (rest g2)
                     (first (rest (val (first g2))))))))
        ))))


;(println graphs/hamming6-4-full)
;(println (map count (vals graphs/hamming6-4-full)))
(maxclique graphs/hamming6-4-full 0)

;(println (seq graphs/hamming6-4-full))
;(println (d (first graphs/hamming6-4-full)))
;(println graphs/hamming6-4-full)
