(ns tic-tac-toe.core)

(def all-moves (range 9))

(defn is-move-possible [board move]
    (= 0 (nth board move))) 

(defn possible-moves [board]
    (filter (fn [move]
                (is-move-possible board move))
            all-moves))
(defn what-board-looks-like-after-move [board move player]
    (assoc board move player))
    
(defn is-board-full [board]
    (empty? (possible-moves board)))