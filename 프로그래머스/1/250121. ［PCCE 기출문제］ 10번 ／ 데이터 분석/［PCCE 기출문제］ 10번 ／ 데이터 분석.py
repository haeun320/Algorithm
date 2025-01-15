def solution(data, ext, val_ext, sort_by):
    type = ["code", "date", "maximum", "remain"]
    extIdx = type.index(ext)
    sortIdx = type.index(sort_by)
    
    result = []
    
    for d in data:
        if (d[extIdx] < val_ext):
            result.append(d)
    
    return sorted(result, key = lambda x: x[sortIdx])