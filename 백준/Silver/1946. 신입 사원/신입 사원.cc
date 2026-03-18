#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct point {
    int doc;
    int iv;
}; 


bool compare(const point &a, const point &b) {
    if (a.doc != b.doc) {
        return a.doc < b.doc; 
    }
    return a.iv < b.iv;
}

int main() {
    int T;
    cin >> T;

    while (T--) { 
        int N;
        cin >> N;

        vector<point> v(N);

        for (int i = 0; i < N; i++) {
            cin >> v[i].doc >> v[i].iv;
        }    
        sort(v.begin(), v.end(), compare);

       
        int count = 1; 
        int best_iv = v[0].iv; 

        for (int i = 1; i < N; i++) {
            if (v[i].iv < best_iv) { 
                count++;
                best_iv = v[i].iv; 
            }
        }
        cout << count << "\n";
    }

    return 0;
}