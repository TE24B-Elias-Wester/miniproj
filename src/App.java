
void main() {
    int val = 0;
    int[][] seats = { {01, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
                      {13, 14, 15, 16},
                      {17, 18, 19, 20} };
    
    while (val != 4) {
        val = 0;
        IO.println("1: Lägg till bokning\n2: Visa innehåll\n3: Beräkna vinst\n4: Avsluta");
        try {
            val = Integer.parseInt(IO.readln("Välj: "));
        } catch (Exception e) {
        }
        switch (val) {
            case 1 -> {

                int seat = chooseSeat(seats);
                enterIdentification(seat, seats);

            }
            case 2 -> {}
            case 3 -> {}
            case 4 -> {break;}
            default -> {
                IO.println("Ogiltigt val, försök igen");
            }
        }
        
    }
    
    printSeats(seats);
    
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

void enterIdentification(int seatsLoc, int[][] seats) {
    int tmp = 0;
    String s_date = "";

    while (true) {
        s_date = IO.readln("Enter your birth date (YYMMDD): ");
        try {
            tmp = Integer.parseInt(s_date);
        } catch (Exception e) {
            IO.println("Incorrect input, try again");
        }
        tmp =+ 1000000;
        if (tmp > 1999999 || tmp < 1000101) {
            IO.println("Incorrect input, try again");
        }
        else break;
    }
    switch (seatsLoc) {
        case 1 -> {seats[0][0] = tmp;}
        case 2 -> {seats[0][1] = tmp;}
        case 3 -> {seats[0][2] = tmp;}
        case 4 -> {seats[0][3] = tmp;}
        case 5 -> {seats[1][0] = tmp;}
        case 6 -> {seats[1][1] = tmp;}
        case 7 -> {seats[1][2] = tmp;}
        case 8 -> {seats[1][3] = tmp;}
        case 9 -> {seats[2][0] = tmp;}
        case 10 -> {seats[2][1] = tmp;}
        case 11 -> {seats[2][2] = tmp;}
        case 12 -> {seats[2][3] = tmp;}
        case 13 -> {seats[3][0] = tmp;}
        case 14 -> {seats[3][1] = tmp;}
        case 15 -> {seats[3][2] = tmp;}
        case 16 -> {seats[3][3] = tmp;}
        case 17 -> {seats[4][0] = tmp;}
        case 18 -> {seats[4][1] = tmp;}
        case 19 -> {seats[4][2] = tmp;}
        case 20 -> {seats[4][3] = tmp;}
    
        default -> {}
    }
}

int chooseSeat(int[][] seats) {

    int foo = 0;
    String s_foo = "";

    while (true) {
        printSeats(seats);
        s_foo = IO.readln("Please select a seat: ");
        try {
            foo = Integer.parseInt(s_foo);
            break;
        } catch (Exception e) {
            IO.println("Incorrect input, try again");
        }
    }
    return foo;
}

void printSeats(int[][] seats) {
    for (int row = 0; row < seats.length; row++) {
        for (int col = 0; col < seats[row].length; col++) {
            IO.print("|");
            if (seats[row][col] > 20) {
                IO.print(" X");
            }
            else {
                if (seats[row][col] < 10) {
                    IO.print(" ");
                }
                IO.print(seats[row][col]);
            }
            if ((col+1) == (seats[col].length/2)) {
                IO.print("|  ");
            }
        }
        IO.print("|\n");
    }
}
//    1  2      3  4
// A |1 |2 |   |3 |4 |
// B |5 |6 |   |7 |8 |
// C |9 |10|   |11|12|
// D |13|14|   |15|16|
// E |17|18|   |19|20|