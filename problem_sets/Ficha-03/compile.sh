
if [ -n "$1" ]; then
    mkdir -p trash
    javac -d trash $1.java
else
    echo "chose a class"
fi
