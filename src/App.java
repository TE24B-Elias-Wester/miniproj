
void main() {
    int val = 0;

    while (val != 4) {
        val = 0;
        IO.println("1: Lägg till bokning\n2: Visa innehåll\n3: Beräkna vinst\n4: Avsluta");
        try {
            val = Integer.parseInt(IO.readln("Välj: "));
        } catch (Exception e) {
        }
        switch (val) {
            case 1 -> {}
            case 2 -> {}
            case 3 -> {}
            case 4 -> {break;}
            default -> {
                IO.println("Ogiltigt val, försök igen");
            }
        }

    }
    int[][] seats = { {0, 0, 0, 0},
                      {0, 0, 0, 0},
                      {0, 0, 0, 0},
                      {0, 0, 0, 0},
                      {0, 0, 0, 0} };
    
    
}

double calculateEarnings(int[][] seats) {
    double profit = 0;
    for (int row = 0; row < seats.length; row++) {
        for (int col = 0; col < seats[row].length; col++) {
            if (seats[row][col] != 0) {
                profit = 299.90 + profit;
            }
        }
    }
    return profit;
}

//    1  2      3  4
// A |1 |2 |   |3 |4 |
// B |5 |6 |   |7 |8 |
// C |9 |10|   |11|12|
// D |13|14|   |15|16|
// E |17|18|   |19|20|