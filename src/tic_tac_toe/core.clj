(ns tic-tac-toe.core)

(def all-moves (range 9))

(defn is-move-possible [board move]
    (= 0 (nth board move))) 

(defn possible-moves [board]
    (filter (fn [move]
                (is-move-possible board move))
            all-moves))
