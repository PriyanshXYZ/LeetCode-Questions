func possibleStringCount(word string) int {
    n := len(word)
    ans := 0

    for i := 0; i < n; i++ {
        cnt := 0
        for i < n-1 && word[i] == word[i+1] {
            i++
            cnt++
        }
        ans += cnt
    }

    return ans + 1
}