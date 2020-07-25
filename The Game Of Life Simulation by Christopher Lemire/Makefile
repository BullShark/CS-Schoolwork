CC=gcc
CFLAGS=-c -Wall -O2 -Wno-unused-result

all: hw2

hw2: hw2.o
	$(CC) -o hw2 hw2.o

hw2.o: hw2.c
	$(CC) $(CFLAGS) hw2.c

clean:
	rm -f a.out hw2.o hw2
