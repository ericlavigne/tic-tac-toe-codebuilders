(ns tic-tac-toe.test-core
  (:use [tic-tac-toe.core] :reload)
  (:use [clojure.test]))

(def eboard [-1 1 1 0 0 1 -1 1 0])

(deftest test-move-possible 
  (is (= false 
	 (is-move-possible eboard 7))
      "Move 7 is not possible.")
  (is (= true 
	 (is-move-possible eboard 8))
      "Move 8 is possible."))
      
(deftest test-possible-moves
  (is (= [3 4 8] 
	 (possible-moves eboard))
      "possible-moves broken"))

(deftest test-board-after-move 
  (is (=  [0 0 0 1 -1 -1 0 1 1]
          (board-after-move [0 0 0 1 -1 -1 0 0 1]
			    7
			    1))
      "board-after-move broken"))
 (def reasonable-moves-board [1 0 -1
                                           0 1 0
                                           0 -1 0])
					   
(deftest remaining-combinations-test
  (is (= #{}
         (remaining-combinations reasonable-moves-board
					  1)))
  (is (= #{#{3 4 5} #{2 5 8}}
         (remaining-combinations reasonable-moves-board
					  5)))
  (is (= #{#{2 5 8} #{0 4 8} #{6 7 8}}
          (remaining-combinations reasonable-moves-board
					   8))))

(deftest test-is-board-full
  (is (= true (is-board-full [1 1 1 1 1 1 1 1 1]))
      "Board is actually full!")
  (is (= false (is-board-full [0 0 0 0 0 0 0 0 0]))
      "Board is actually empty!")
  (is (= false (is-board-full [1 0 1 0 -1 0 0 -1 0]))
      "Board is not full!"))

(deftest test-won-by-method
  (is (= true
	 (won-by-method? [ 1  0 -1 
			  -1  1  0 
			  -1  0  1]
			 [0 4 8]
			 1))
      "won-by-method broken")
  (is (= false
	 (won-by-method? [ 1  0 -1 
			  -1  1  0 
			  -1  0  0]
			 [0 4 8]
			 1))
      "won-by-method broken"))

(deftest test-player-won?
  (is (= true
         (player-won? [ 1  0 -1 
		       -1  1  0 
		       -1  0  1]
                      1))
      "Player 1 should win this"))
      
(deftest max-key-test
  (is (= "boulder"
         (apply max-key count
	              ["grain" "pebble" "orange" "boulder"]))
     "Max value is actually 7"))

(deftest max-value-test
  (is (= 7
          (apply max-value count
	               ["grain" "pebble" "orange" "boulder"]))
     "Max value is actually 7"))

(comment(deftest test-expected-result-of-move
	  (is (= true
		 (expected-result-of-move [-1 -1 0
					   -1 0 1
					   1 1 -1]
					  -1
					  2)))))

(deftest expected-result-test
  (is (= -1 
         (expected-result [-1 -1 0
			   1 -1 1
			   1 1 -1]
                          -1))
      "Player -1 should have won")
  (is (= 0 
         (expected-result [0 0 0
			   0 0 0
			   0 0 0]
			  -1))
      "No one should have won")
  (is (= 1 
         (expected-result [-1 1 -1
			   1 1 0
                           -1 1 -1]
			  1))
      "Player 1 should have won"))

;(deftest best-move-test
;  (is (= 2
;         (best-move [1 -1 0
;	                   -1 0 1
;			   -1 0 1
			    
