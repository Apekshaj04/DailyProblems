/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    filtered = []
    for(let i = 0;i<arr.length;i++){
        var a = fn(arr[i],i);
        filtered.push(a);
    }
    return filtered;
};