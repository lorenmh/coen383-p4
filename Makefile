all:
	javac p4/src/*.java

run:
	java -cp p4/src/ Main

clean:
	rm p4/src/*.class
