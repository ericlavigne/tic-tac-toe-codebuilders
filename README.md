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
          =                                  
          =                                  
     possible-moves [board]
            =   
          =============
          =           =
     all-moves        =
                      =
         is-move-possible [board move]
