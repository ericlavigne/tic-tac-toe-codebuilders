(ns tic-tac-toe.core)

(def all-moves (range 9))

(defn is-move-possible [board move]
  (= 0 (nth board move))) 

(defn possible-moves [board]
  (filter (fn [move]
	    (is-move-possible board move))
	  all-moves))

(defn board-after-move [board move player]
  (assoc board move player))
    
(defn is-board-full [board]
  (empty? (possible-moves board)))
    
(def winning-combinations 
     [[0 1 2] [3 4 5] 
      [6 7 8] [0 3 6] 
      [1 4 7] [2 5 8] 
      [0 4 8] [2 4 6]])
    
(defn won-by-method? [board method player]
  (every? (fn [position]
	    (= player
	       (nth board position)))
	  method))
		
(defn player-won? [board player]
  (some (fn [winning-combination]
	  (won-by-method? board winning-combination player))
	winning-combinations))

(defn who-won [board] 
  (cond
    (player-won? board 1) 1 
    (player-won? board -1) -1 
    true 0))
    
(defn expected-result-of-move [board player move expected-result]
  (let [new-board (board-after-move board move player)
         new-player (* -1 player)]
         (expected-result new-board new-player)))
	 
(defn expected-result [board next-player]
  (let [winner (who-won board)]
    (cond (not (= 0 winner)) winner
    (is-board-full board) 0
    true (let [results (map (fn [move]
                                     (expected-result-of-move board
				                                         next-player
									 move
									 expected-result))
				    (possible-moves board))]
	    (reduce (if (= next-player 1) max min)
	                results)))))