# write a makefile to compile all files using step by step compiling 
# principle
app: QueryApp.o QueryFunctions.o
	g++ QueryApp.cpp QueryFunctions.h QueryFunctions.cpp -o QueryApp
# add a run label to makefile to run your program with make and the run label
run:    
	./QueryApp
# add a clean label to clean all object and executable files
clean:
	rm *.o
	rm QueryApp

# you will run makefile from Zylab console 