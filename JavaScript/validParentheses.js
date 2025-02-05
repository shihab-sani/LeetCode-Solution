/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let res = [];
    for (let i of s) {
        if(i === "(" || i === "{" || i === "[") {
            res.push(i);
        } else if (res.length === 0) {
            return false;
        } else if (i === ")" && res[res.length-1] !== "(") {
            return false;
        } else if (i === "}" && res[res.length-1] !== "{") {
            return false;
        } else if (i === "]" && res[res.length-1] !== "[") {
            return false;
        } else {
            res.pop();
        }
    }
    if (res.length !== 0) {
        return false;
    }
    return true;
};