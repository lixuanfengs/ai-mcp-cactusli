#!/bin/bash

# https://cr.console.aliyun.com/cn-hangzhou/instance/credentials

# Ensure the script exits if any command fails
set -e

# Define variables for the registry and image
REGISTRY="registry.hub.docker.com"
NAMESPACE="cactuslixf"
IMAGE_NAME="mcp-server-csdn-app"
IMAGE_TAG="1.0"

# 读取本地配置文件
if [ -f ".local-config" ]; then
  source .local-config
else
  echo ".local-config 文件不存在，请创建并填写 USERNAME 和 PASSWORD"
  exit 1
fi

# Login to Docker hub
echo "Logging into Docker Registry..."
docker login --username="${USERNAME}" --password="${PASSWORD}" $REGISTRY

# Tag the Docker image
echo "Tagging the Docker image..."
docker tag ${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG} $REGISTRY}/${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG}

# Push the Docker image to Docker hub
echo "Pushing the Docker image to Docker hub..."
docker push ${REGISTRY}/${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG}

echo "Docker image pushed successfully! "

echo "检出地址：docker pull ${REGISTRY}/${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG}"
echo "标签设置：docker tag ${REGISTRY}/${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG} ${NAMESPACE}/${IMAGE_NAME}:${IMAGE_TAG}"

# Logout from  Docker Registry
echo "Logging out from Docker Registry..."
docker logout $REGISTRY
