CC= gcc
TEST_EXEC = test

CFLAGS = -g -W -Wall -std=c99
LDFLAGS = -lm
CFILES = $(wildcard *.c)
HFILES = $(wildcard *.h) 


OFILES = test.o 

all: $(EXEC) $(TEST_EXEC) 

    
test : $(OFILES)
	$(CC)  $^ -lm -o $(TEST_EXEC)

%.o : %.c $(HFILES)
	$(CC)  -c $< -o $@ $(CFLAGS)


clean :
	rm -f $(EXEC)
	rm -f $(TEST_EXEC)
	rm -f $(OFILES)
	rm -f *~





