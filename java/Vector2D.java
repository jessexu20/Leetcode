/*
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.

*/


public class Vector2D {
    List<List<Integer>> vec;
    int x;int y;
    public Vector2D(List<List<Integer>> vec2d) {
        vec = new ArrayList(vec2d);
        x=0;y=0;
    }

    public int next() {
        if(hasNext()){
            return vec.get(x).get(y++);
        }
        else return 0;
    }

    public boolean hasNext() {
        
        while(x<vec.size() && y >= vec.get(x).size()){
            x++;
            y=0;
        }
        if(x<vec.size()) return true;
        else return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */