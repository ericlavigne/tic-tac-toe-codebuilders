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
    
(def winning-combinations 
    [[0 1 2][3 4 5] 
    [6 7 8][0 3 6] 
    [1 4 7][2 5 8] 
    [0 4 8][2 4 6]])
    
(defn won-by-method? [board method player]
    (every? (fn [position]
		    (= player
			(nth board position)))
		method))