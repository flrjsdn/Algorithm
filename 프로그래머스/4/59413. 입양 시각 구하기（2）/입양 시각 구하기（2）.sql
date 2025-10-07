WITH RECURSIVE a as 
(
    select 0 as num     # 초기값 설정
    union all
    select num+1        # 재귀식 설정
    from a
    where num < 23      # 정지 조건 (23시까지 표현)
)

select a.num as HOUR, ifnull(b.cnt,0) as COUNT
from a left join 
(
select date_format(DATETIME, '%H') date_hour,
        count(date_format(DATETIME, '%H')) cnt
from ANIMAL_OUTS 
group by date_format(DATETIME, '%H')
) b
on a.num = b.date_hour
GROUP BY a.NUM
ORDER BY a.NUM;
