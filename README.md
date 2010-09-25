# Tic-Tac-Toe

This game is a work-in-progress. Eventually you will 
be able to play Tic-Tac-Toe against the computer, or 
possibly another person, via a web application.

## Plans

> So far, we have finished possible-moves and its 
> dependencies.

               best-move [board who-plays-next]
                        =
          ==========================================
          =             =                          =
          =             =                          =
          =             =                what-board-looks-like-after-move [board move player]
          =             =
          =             =
          =             ============================
          =                                        =
          =                                 expected-game-result [board who-plays-next]
          =                                        =
          =                                 ===============================================
     possible-moves [board]                        =                =
            =                               is-board-full [board]      =
          =============                                            =
          =           =                                      who-won [board]
     all-moves     =                                             =             =
		       =                                            =             =
         is-move-possible [board move]                   =           player-won? [board player]
										    =
						    Winning-combinations   won-by-method? [board method player]
						    
In order to make (reasonable-moves run) faster we need to write the following
functions:

(remaining-combinations board move)
(combo-value board combo)
(hightest-combo-value board move)

We also need to test best-move.