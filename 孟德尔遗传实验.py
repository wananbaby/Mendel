# -*- coding: utf-8 -*-
"""
    孟德尔遗传实验（非染色体）
    单基因版
    @anther Yanshen.zhang@radiometer.cn xyanz
"""

# 输入基因组
father = input("父亲:")
mother = input("母亲:")
gene = input("基因表现类:")

# 基因组分割
list_f = list(father)
list_m = list(mother)
list_g = gene.split(",")
k = len(list_g)
# 下一代代基因组
list_new = []
for i in list_f:
    for j in list_m:
        value = i + j
        '''
        不区分顺序反转
        if value == "aA":
            value = j + i
        '''
        
        list_new.append(value)

# 输出所有子代组合
print(list_new)

dict_1 = {}
for i in range(0,k):
    dict_1[list_g[i]] = list_new.count(list_g[i])

# 输出子代组合比例
print(dict_1)

dict_2 = {"A":0,"a":0}

for i in range(0,4):
    if list_new[i].find("A")!=-1:
        dict_2["A"] = dict_2["A"] + 1
    elif list_new[i].find("a")!=-1:
        dict_2["a"] = dict_2["a"] + 1
# 输出基因表现比
print(dict_2)
'''
多基因版：  key:(dict_2_i:[key]+dict_2_(i+1):[key])
       ：value:(dict_2_i:[value]*dict_2_(i+1)[value])
    输入类型：父代基因，String；基因类型列表；
    输出类型：形状比：字典；
'''
def Mendel(father, mother, gene):
    # 基因组分割
    list_f = list(father)
    list_m = list(mother)
    list_g = gene.split(",")
    k = len(list_g)
    # 下一代代基因组
    list_new = []
    for i in list_f:
        for j in list_m:
            value = i + j
            '''
            不区分顺序反转
            if value == "aA":
                value = j + i
            '''

            list_new.append(value)

    # 输出所有子代组合
    # print(list_new)

    dict_1 = {}
    for i in range(0, k):
        dict_1[list_g[i]] = list_new.count(list_g[i])

    # 输出子代组合比例
    # print(dict_1)

    dict_2 = {"A": 0, "a": 0}

    for i in range(0, 4):
        if list_new[i].find("A") != -1:
            dict_2["A"] = dict_2["A"] + 1
        elif list_new[i].find("a") != -1:
            dict_2["a"] = dict_2["a"] + 1
    # 输出基因表现比
    #print(dict_2)
    return dict_2

def Mender_gene_experiment(father, mother, gene, n):# father,mother:父代基因;gene:基因组合分类;n:基因组合数量
    list_f = father.split(",")
    list_m = list(mother)
    list_g = gene.split(",",n)