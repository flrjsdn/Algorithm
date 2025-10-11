SELECT
    (CASE
        -- A: Front End 스킬 그룹 AND Python 스킬 보유
        WHEN D.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')
             AND D.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') THEN 'A'
        -- B: C# 스킬 보유 (A 그룹 조건에 해당하지 않을 때만 체크됨)
        WHEN D.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') THEN 'B'
        -- C: Front End 스킬 그룹 보유 (A/B 그룹 조건에 해당하지 않을 때만 체크됨)
        WHEN D.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') THEN 'C'
    END) AS GRADE,
    D.ID,
    D.EMAIL
FROM DEVELOPERS D
HAVING GRADE IS NOT NULL
ORDER BY GRADE, D.ID;