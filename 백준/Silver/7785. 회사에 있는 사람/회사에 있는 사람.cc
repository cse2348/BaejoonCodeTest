#include <iostream>
#include <set>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >>n;
    string name,status;

    set<string,greater<string>> s;

    for(int i=0;i<n;i++){
        cin >> name >> status;
        if(status == "enter"){
            s.insert(name);
        } else {
            s.erase(name);
        }
    }

    for(string name : s){
        cout << name << "\n";
    }
    return 0;
}