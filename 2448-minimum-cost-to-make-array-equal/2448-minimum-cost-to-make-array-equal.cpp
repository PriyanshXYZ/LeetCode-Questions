class Solution {
public:
    long long minCost(vector<int>& n, vector<int>& cost) {
        vector<long long> id(n.size()), cost_l(n.size());
        iota(begin(id), end(id), 0);
        sort(begin(id), end(id), [&](int i, int j){
            return n[i] < n[j];
        });
        for (long long i = 0, psum = 0; i < n.size() - 1; ++i) {
            psum += cost[id[i]];
            cost_l[i + 1] = cost_l[i] + psum * (n[id[i + 1]] - n[id[i]]);
        }
        long long res = cost_l.back(), cost_r = 0;
        for (long long j = n.size() - 1, psum = 0; j > 0; --j) {
            psum += cost[id[j]];
            cost_r += psum * (n[id[j]] - n[id[j - 1]]);
            res = min(res, cost_l[j - 1] + cost_r);
        }
        return res;
    }
};