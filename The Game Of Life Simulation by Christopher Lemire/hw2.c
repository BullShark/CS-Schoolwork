/*
 * The Game Of Life Simulation by Christopher Lemire
 */

#include <stdio.h>

#define DEAD 0
#define ALIVE 1
#define COLS 50
#define ROWS 30

typedef enum { FALSE = 0, TRUE = 1 } bool;

static void initialize_grid_to_all_dead(int [ROWS][COLS]);
static void display_grid(int [ROWS][COLS]);
static void set_alive(int [ROWS][COLS], int, int);
static void set_dead(int [ROWS][COLS], int, int);
static bool spawn_new_generation(int [ROWS][COLS], int [ROWS][COLS]);
static int get_num_neighbors(int [ROWS][COLS], int, int);
static bool is_alive(int [ROWS][COLS], int, int);
static bool compare_two_grids(int [ROWS][COLS], int [ROWS][COLS]);

int main() {
  /*
   * Grids are used in a circular motion
   * And used to make comparision for new generation
   * And for one and two generations ago
   */
  int gridA[ROWS][COLS];
  int gridB[ROWS][COLS];
  int gridC[ROWS][COLS];
  
  /* Zero-write */
  initialize_grid_to_all_dead(gridA);
  initialize_grid_to_all_dead(gridB);
  initialize_grid_to_all_dead(gridC);

  int max = 0;

  printf("Welcome to The Game Of Life Simulator written by Christopher Lemire.\n");

  printf("\nNow the first initial generation will be set.\n"
    "Enter cordinates for one cell at a time for each alive cell.\n"
    "All cells not set to be alive are set to be dead.\n"
    "Enter \"-1 -1\" when you are done setting up the initial generation.\n\n");

  printf("Enter a coordinate in the form \"R C\"\n"
    "where R is an integer for the row between 1 and %d\n"
    "and C is an integer for the column between 1 and %d\n"
    "or \"-1 -1\" to finish setting up the initial generation.\n"
    "The top left-most cell is \"1 1\".\n"
    "Additionally, you can type \"0 0\" anytime to display the grid.\n",
    ROWS, COLS);

  int r = -1, c = -1;

  /*
   * Get alive cell coordinates as input
   */
  do {
    printf("\"R C\": ");
    scanf("%d %d", &r, &c);
    fflush(stdin);
    /*
     * Don't expect the end-user to know that
     * Array indexes start at 0
     * That's why I ask for a number between
     * 1 and ROWS for rows and
     * 1 and COLS for columns
     */
    if(r == 0 && c == 0) {
      display_grid(gridB);
      continue;
    } /* No need for else-if here because of the continue */
    
    if(r > 0 && c > 0 && c <= ROWS && r <= COLS) {
      set_alive(gridB, r-1, c-1);
    } else {
      break;
    }
  } while(TRUE);

  printf("Enter the max number of generations to simulate: ");
  scanf("%d", &max);
  fflush(stdin);

  /*
   * This loop stops when one of three conditions is met
   *
   * 1) All organisms died
   * 2) The pattern of organisms repeated itself in
   *    The last generation or the generation before that
   * 3) The inputted max number of generations is reached
   *
   * The initial generation will be pointed to by next_gen
   */
  int (*prev_gen)[COLS] = gridA;
  int (*current_gen)[COLS] = gridB;
  int (*next_gen)[COLS] = gridC;

  int (*temp_ptr)[COLS] = NULL;

  bool equivalent = FALSE, liveontonextgen = TRUE;
  int gen;
  for(gen = 0; ( liveontonextgen && gen < max && !equivalent ); gen++) {
    printf("*** GENERATION: %i ***\n", gen+1);

    display_grid(current_gen);

    liveontonextgen = spawn_new_generation(current_gen, next_gen);

    spawn_new_generation(current_gen, next_gen);

    if(gen == 1) {
      equivalent = compare_two_grids(current_gen, next_gen);
    } else if(gen > 1) {
      equivalent = compare_two_grids(current_gen, next_gen) ||
                   compare_two_grids(prev_gen, next_gen); 
    }

    /*
     * Rotating in a circular fasion
     */
    temp_ptr = prev_gen;
    prev_gen = current_gen;
    current_gen = next_gen;
    next_gen = temp_ptr;
  } // EOF for loop

  if(gen == max) {
    printf("The inputted max %i of generations was reached.\n", max);
  } else if(equivalent) {
    printf("The pattern of organisms repeated itself in\n"
      "the last generation or the generation before that.\n");
  } else if(!liveontonextgen) {
    printf("All organisms died.\n");
  }

  return 0;
}

/*
 * Sets all cells of a grid to be
 * DEAD/No organisms living
 */
static void initialize_grid_to_all_dead(int grid[ROWS][COLS]) {
  int r, c;
  /* Iterates each column */
  for(r = 0; r < ROWS; r++) {
    /* Iterates each column */
    for(c = 0; c < COLS; c++) {
      grid[r][c] = DEAD;
    }
  } // EOF outer loop
} // EOF function

/*
 * Displays a conceptional view of the grid
 */
static void display_grid(int grid[ROWS][COLS]) {
  int r, c;
  for(c = 0; c < COLS+1; c++) {
    if(c % 5 == 0) {
      printf("+");
    } else {
      printf("-");
    }
  }
  printf("\n");

  /* Iterates each column */
  for(r = 0; r < ROWS; r++) {
    /* Iterates each row */
    for(c = 0; c < COLS; c++) {
      if(c == 0) {
        if((r+1) % 5 == 0) {
          printf("+");
        } else {
          printf("-");
        }
      }
      if(grid[r][c] == DEAD) {
        printf(" ");
      } else {
        printf("x");
      }
    }
    printf("\n"); /* New line after each row */
  }
  printf("\n"); /* New line after the grid */
}

/*
 * In the game
 * A cell is either dead or alive
 * Alive indicates an organism lives there
 * This function sets a specific cell
 * Alive to indicate an organism lives there
 */
static void set_alive(int grid[ROWS][COLS], int r, int c) {
  grid[r][c] = ALIVE;
}

/*
 * Similar to set_alive()
 * Except that it does the opposite;
 * Sets the organism at a particular
 * Cell to be DEAD
 */
static void set_dead(int grid[ROWS][COLS], int r, int c) {
  grid[r][c] = DEAD;
}

/*
 * Spawns the new generation of living and dying organisms
 *
 * Folloing The Rules Of Life
 * 1) Any live cell with fewer than two live neighbours dies, as if caused by under-population
 * 2) Any live cell with two or three live neighbours lives on to the next generation
 * 3) Any live cell with more than three live neighbours dies, as if by overcrowding
 * 4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
 *
 * Returns TRUE if organisms live on to next generation
 * Otherwise FALSE if all organisms die off
 */
static bool spawn_new_generation(int grid_current[ROWS][COLS], int grid_new[ROWS][COLS]) {
  int r, c, nghbrs = 0;
  /*
   * Will be set to true if at least one call to
   * set_alive() is made for the next generation
   */
  bool liveontonextgen = FALSE;
  /* Iterates each column */
  for(r = 0; r < ROWS; r++) {
    /* Iterates each row */
    for(c = 0; c < COLS; c++) {
      nghbrs = get_num_neighbors(grid_current, r, c);

      if(grid_current[r][c] == ALIVE) {
        /*
         * Cell dies either to over-population or under-population
         */
        if(nghbrs < 2 || nghbrs > 3) {
          set_dead(grid_new, r, c);
        } else {
          set_alive(grid_new, r, c);
          liveontonextgen = TRUE;
        }
      } else if(grid_current[r][c] == DEAD) {
        if(nghbrs == 3) {
          set_alive(grid_new, r, c);
          liveontonextgen = TRUE;
        } else {
          set_dead(grid_new, r, c);
        }
      } // EOF last elseif
    } // EOF inner loop
  } // EOF outer loop

      //TODO Remove printf debug statement
      //printf("%d\n", nghbrs);
  
  return liveontonextgen;
} // EOF function

/*
 * Returns the number of living organism neighbors
 * By checking the eight adjacent cells
 */
static int get_num_neighbors(int grid[ROWS][COLS], int r, int c) {
  int nghbrs = 0, noop;
  /*
   * If any if expression evaluates to true
   * A cell located outside the grid is being
   * Checked and
   * Assumed to be dead
   * So nghbrs (neighbors) will not be incremented
   *
   * http://www.google.com/search?q=define:noop 
   */

  /* Up neighbor */
  if(r-1 >= 0) {
    noop = (is_alive(grid, r-1, c)) ? nghbrs++,0 : 0;
  }

  /* Down neighbor */
  if(r+1 < ROWS) {
    noop = (is_alive(grid, r+1, c)) ? nghbrs++,0 : 0;
  }

  /* Left neighbor */
  if(c-1 >= 0) {
    noop = (is_alive(grid, r, c-1)) ? nghbrs++,0 : 0;
  }

  /* Right neighbor */
  if(c+1 < COLS) {
    noop = (is_alive(grid, r, c+1)) ? nghbrs++,0 : 0;
  }

  /* Up-left neighbor */
  if(r-1 >= 0 && c-1 >= 0) {
    noop = (is_alive(grid, r-1, c-1)) ? nghbrs++,0 : 0;
  }

  /* Up-right neighbor */
  if(r-1 >= 0 && c+1 < COLS) {
    noop = (is_alive(grid, r-1, c+1)) ? nghbrs++,0 : 0;
  }

  /* Down-left neighbor */
  if(r+1 < ROWS && c-1 >= 0) {
    noop = (is_alive(grid, r+1, c-1)) ? nghbrs++,0 : 0;
  }

  /* Down-right neighbor */
  if(r+1 < ROWS && c+1 < COLS) {
    noop = (is_alive(grid, r+1, c+1)) ? nghbrs++,0 : 0;
  }

  return nghbrs;
}

/*
 * Returns TRUE if a specific cell location
 * For the grid being passed in is alive
 */
static bool is_alive(int grid[ROWS][COLS], int r, int c) {
  return grid[r][c];
}

/*
 * True if both grids are equivalent
 * False otherwise
 */
static bool compare_two_grids(int gridA[ROWS][COLS], int gridB[ROWS][COLS]) {
  int r, c;
  /* Iterates each column */
  for(r = 0; r < ROWS; r++) {
    /* Iterates each row */
    for(c = 0; c < COLS; c++) {
      /* Break as soon as a difference is found */
      if(gridA[r][c] != gridB[r][c]) {
        return FALSE;
      }
    } // EOF inner loop
  } // EOF outer loop

  /*
   * If the execution reaches this statement
   * Both grids are equivalent
   */
  return TRUE;
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       