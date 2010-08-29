(ns tic-tac-toe.core)

(def all-moves (range 9))

(defn move-possible [board move](= 0 (nth board move))) 
