/*
 * @lc app=leetcode.cn id=264 lang=javascript
 *
 * [264] 丑数 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    // 已知第一个丑数为1，可以看出其余的丑数都是由现有的丑数分别乘以2,3,5得到新的丑数
    // 如果不停地把已存在的丑数分别乘以2,3,5得到新的丑数，那么这里肯定有重复计算，
    // 比如6就会在3x2和2x3的时候算出来两次
    // 为了避免重复，我们这么理解：一个丑数肯定是由另一个丑数乘以2,3,5中至少其中一个数得来的
    // 那么我们就把丑数分为三类，分别记为乘以2,3,5来的数
    // 那么丑数就分为2的所有幂，3的所有幂，5的所有幂
    // 当然这三类会有重复
    // 我们用三个指针，记录对应的倍数，用来计算下一个丑数

    // 官方题解里提到的三个指针p2，p3，p5，但是没有说明其含义，
    // 实际上pi的含义是有资格同i相乘的最小丑数的位置。
    // 这里资格指的是：如果一个丑数nums[pi]通过乘以i可以得到下一个丑数，
    // 那么这个丑数nums[pi]就永远失去了同i相乘的资格（没有必要再乘了），
    // 我们把pi++让nums[pi]指向下一个丑数即可。
    // 不懂的话举例说明：
    // 一开始，丑数只有{1}，1可以同2，3，5相乘，取最小的1×2=2添加到丑数序列中。
    // 现在丑数中有{1，2}，在上一步中，1已经同2相乘过了，所以今后没必要再比较1×2了，
    // 我们说1失去了同2相乘的资格。
    // 现在1有与3，5相乘的资格，2有与2，3，5相乘的资格，但是2×3和2×5是没必要比较的，
    // 因为有比它更小的1可以同3，5相乘，所以我们只需要比较1×3，1×5，2×2。
    // 依此类推，每次我们都分别比较有资格同2，3，5相乘的最小丑数，选择最小的那个作为下一个丑数，
    // 假设选择到的这个丑数是同i（i=2，3，5）相乘得到的，所以它失去了同i相乘的资格，
    // 把对应的pi++，让pi指向下一个丑数即可。

    let p2 = 0, p3 = 0, p5 = 0;
    let res = [];
    res[0] = 1;
    // 计算出前n个丑数
    for (let i = 1; i < n; i++) {
        // 三个p指向下一轮丑数的倍数，分别乘以2,3,5得到下一轮的丑数
        let n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
        // 这三个丑数是还没有放到res里的，从中取出最小的一个放进去
        res[i] = Math.min(n2, n3, n5);
        // 如果新生成的丑数是由p2生成来的，那么p2+1作为下一个倍数
        // 这里可能会重复判断，为的是当一个丑数可以同时由两个p生成的时候，把这些p都前移，
        // 这样都前移就可以避免重复计算了
        if (res[i] === n2) {
            p2++;
        }
        if (res[i] === n3) {
            p3++;
        }
        if (res[i] === n5) {
            p5++;
        }
    }

    return res[n - 1];

};
// @lc code=end

