class main:
    def __init__(self):
        self.t = int(input())
        self.tc = [input() for _ in range(self.t)]
        self.answer = 0

    def solve(self):
        for case in self.tc:  # 테스트 케이스마다 변수 초기화
            self.answer = 0
            low, high = 0, len(case) - 1

            while low < high:
                if case[low] == case[high]:  # 포인터들이 가리키는 문자가 같다면 포인터 갱신
                    low += 1
                    high -= 1
                else:  # 같지 않다면
                    if self.is_valid(case[:low] + case[low + 1:]): 
                        break
                    if self.is_valid(case[:high] + case[high + 1:]): 
                        break
                    self.answer = 2
                    break
            print(self.answer)

    def is_valid(self, string):
        if string == string[::-1]:
            self.answer = 1
            return True
        return False


problem = main()
problem.solve()